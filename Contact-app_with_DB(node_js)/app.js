const express = require('express')
const morgan = require('morgan')
const mongoose = require('mongoose')

const router = require('./routes')

const app = express()

app.set('view engine', 'ejs')

app.use(morgan('dev'))
app.use(express.urlencoded({extended: true}))
app.use(express.json())

app.use('/contacts', router)

const PORT = process.env.PORT || 8080
mongoose
    .connect(`mongodb+srv://user1:pass1@cluster0.wa1q4.mongodb.net/dbtest1?retryWrites=true&w=majority`, {
        useNewUrlParser: true,
        useUnifiedTopology: true
    })
    .then(() => {
        app.listen(PORT, () => {
            console.log(`SERVER IS RUNNING ON PORT ${PORT}`);
        })
    })
    .catch(e => {
        console.log(e);
    })
