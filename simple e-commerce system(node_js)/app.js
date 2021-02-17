require('dotenv').config()
const express = require('express')
// const morgan = require('morgan')
const mongoose = require('mongoose')
// const session = require('express-session')
// const MongoDBStore = require('connect-mongodb-session')(session)
// const flash = require('connect-flash')
const config = require('config')
const chalk = require('chalk')

//
// const testConsole = require('debug')('app:test')
// const dbConsole = require('debug')('app:db')
//

//
// testConsole('This is a test Console')
// dbConsole('This is a DB Console')
//

// import routes
// const authRoutes = require('./routes/authRoute')
// const dashboardRoutes = require('./routes/dashboardRoute')

const setMiddleware = require('./middleware/middleware')

const setRoute = require('./routes/routes')

// import middleware
// const {bindUserWithRequest} = require('./middleware/authMiddleware')
// const setLocals = require('./middleware/setLocals')



// playground routes
// const validatorRoute = require('./playground/validator')

// let DB_USER = process.env.DB_USER
// let DB_PASSWORD = process.env.DB_PASSWORD

const MONGODB_URI = `mongodb+srv://${config.get('db-username')}:${config.get('db-password')}@cluster0.wa1q4.mongodb.net/exp-blog?retryWrites=true&w=majority`

// const store = new MongoDBStore({
//     uri: MONGODB_URI,
//     collection: 'sessions',
//     expires: 1000 * 60 * 60 * 2
// })


//
const app = express()

// console.log(config.get('name'))

// const config = require('./config/config')
// if(app.get('env').toLowerCase() === 'development') {
//     console.log(config.dev.name);
// } else {
//     console.log(config.prod.name);
// }

// if(app.get('env').toLowerCase() === 'development') {
//     app.use(morgan('dev'))
// }

// console.log(process.env.NODE_ENV);
// console.log(app.get('env'));


// setup view Engine
app.set('view engine', 'ejs')
app.set('views', 'views')

// Middleware Array
// const middleware = [
//     // morgan('dev'),
//     express.static('public'),
//     express.urlencoded({ extended: true }),
//     express.json(),
//     session({
//         secret: config.get('secret'),
//         resave: false,
//         saveUninitialized: false,
//         store: store
//     }),
//     bindUserWithRequest(),
//     setLocals(),
//     flash()
// ]
// app.use(middleware)
//
// app.use('/auth', authRoutes)
// app.use('/dashboard', dashboardRoutes)
// // app.use('/playground', validatorRoute)

// app.get('/', (req, res) => {
//     res.json({
//         message: 'Hello World'
//     })
// })
//

// using middleware from middleware directory
setMiddleware(app)

// using route from route directory
setRoute(app)



// 
app.use((req, res, next) => {
    let error = new Error('404 Page Not Found')
    error.status = 404
    next(error)
})

app.use((error, req, res, next) => {
    if(error.status === 404) {
        return res.render('pages/error/404', { flashMessage: {} })
    }
    console.log(chalk.red.inverse(error.message));
    console.log(error);
    res.render('pages/error/500', { flashMessage: {} })
})

const PORT = process.env.PORT || 8080
mongoose.connect(MONGODB_URI, {useNewUrlParser: true, useUnifiedTopology: true})
    .then(() => {
        console.log(chalk.green('Database Connected'));
        app.listen(PORT, () => {
            console.log(chalk.blue(`SERVER IS RUNNING ON PORT ${PORT}`));
        })
    })
    .catch(e => {
        return console.log(e);
    })

