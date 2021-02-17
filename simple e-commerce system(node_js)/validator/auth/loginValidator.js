const {body} = require('express-validator')

module.exports = [
    body('email')
        .not().isEmpty().withMessage('Please procide your Email'),
    body('password')
        .not().isEmpty().withMessage('Please procide your Password')
]