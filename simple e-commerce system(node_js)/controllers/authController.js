const bcryptjs = require('bcryptjs')
const { validationResult } = require('express-validator')
const Flash = require('../utils/Flash')

const User = require('../models/User')
const errorFormatter = require('../utils/validationErrorFormatter')

exports.signupGetController = (req, res, next) => {
    res.render('pages/auth/signup',{
        title: 'Sign Up',
        error: {},
        value: {},
        flashMessage: Flash.getMessage(req)
    })
}
exports.signupPostController = async (req, res, next) => {

    let { username, email, password } = req.body

    let errors = validationResult(req).formatWith(errorFormatter)

    if (!errors.isEmpty()) {
        req.flash('fail', 'please check your Form')
        return res.render('pages/auth/signup', {
            title: 'Sign Up',
            error: errors.mapped(),
            value: {
                username, email, password
            },
            flashMessage: Flash.getMessage(req)
        })
    }

    try {

        let hashedPassword = await bcryptjs.hash(password, 11)

        let user = new User({
            username,
            email,
            password: hashedPassword
        })

        // let createdUser = await user.save()
        // console.log('User CreatedSuccessfully', createdUser)
        await user.save()
        req.flash('success', 'User Created Successfully')
        res.redirect('/auth/login')
    } catch (e) {
        // console.log(e)
        next(e)
    }
}

exports.loginGetController = (req, res, next) => {
    // console.log(req.session.isLoggedIn, req.session.user);
    res.render('pages/auth/login', { 
        title: 'Log In Your Account',
        error: {},
        flashMessage: Flash.getMessage(req)
    })

}
exports.loginPostController = async (req, res, next) => {
    let { email, password } = req.body

    let errors = validationResult(req).formatWith(errorFormatter)

    if (!errors.isEmpty()) {
        req.flash('fail', 'Please Check Your From')
        return res.render('pages/auth/login', {
                title: 'Log In Your Account',
                error: errors.mapped(),
                // isLoggedIn,
                flashMessage: Flash.getMessage(req)
            })
    }

    try {
        let user = await User.findOne({ email })
        if (!user) {
            req.flash('fail', 'PLease Provide a valid email and password')
            return res.render('pages/auth/login', {
                title: 'Log In Your Account',
                error: {},
                flashMessage: Flash.getMessage(req)
            })
        }

        let match = await bcryptjs.compare(password, user.password)
        if (!match) {
            req.flash('fail', 'PLease Provide a valid email and password')
            return res.render('pages/auth/login', {
                title: 'Log In Your Account',
                error: {},
                flashMessage: Flash.getMessage(req)
            })
        }

        req.session.isLoggedIn = true
        req.session.user = user
        req.session.save(err => {
            if (err) {
                console.log(err)
                return next(err)
            }
            req.flash('success', 'Successfully Logged In')
            res.redirect('/dashboard')
        })

    } catch (e) {
        // console.log(e);
        next(e)
    }
}

exports.logoutController = (req, res, next) => {
    req.session.destroy(err => {
        if (err) {
            // console.log(err)
            return next()
        }
        // req.flash('success', 'Successfully Logout')
        return res.redirect('/auth/login')
    })
}