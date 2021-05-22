const router = require('express').Router()

const signupValidator = require('../validator/auth/signupValidator')
const loginValidator = require('../validator/auth/loginValidation')
const { isUnAuthenticated } = require('../middleware/authMiddleware')
const {
    signupGetController,
    signupPostController,
    loginGetController,
    loginPostController,
    logoutController
} = require('../controllers/autoController')


router.get('/signup', isUnAuthenticated, signupGetController)
router.post('/signup', isUnAuthenticated, signupValidator, signupPostController)

router.get('/login', isUnAuthenticated, loginGetController)
router.post('/login', isUnAuthenticated, loginValidator, loginPostController)

router.get('/logout', logoutController)

module.exports = router