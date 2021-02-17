const router = require('express').Router()

const {
    getAllContact,
    createContact,
    deleteContact
} = require('./controllers')

router.get('/', getAllContact)

router.post('/', createContact)

router.get('/delete/:id', deleteContact)

module.exports = router