const router = require('express').Router()

const { isAuthenticated } = require('../../middleware/authMiddleware')

const {
    commentPostController,
    replayCommentPostController
} = require('../controllers/commentController')

const {
    likesGetController,
    dislikesGetController
} = require('../controllers/likeDislikeController')

const {
    bookmarkGetController
} = require('../controllers/bookmarkController')

router.post('/comment/:postId', isAuthenticated, commentPostController)
router.post('/comment/replies/:postId', isAuthenticated, replayCommentPostController)

router.get('/likes/:postId', isAuthenticated, likesGetController)
router.get('/dislikes/:postId', isAuthenticated, dislikesGetController)

router.get('/bookmarks/:postId', isAuthenticated, bookmarkGetController)

module.exports = router