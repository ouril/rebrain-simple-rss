package ru.rebrain.simple_rss.model

/**
 * Created by ftoptas on 24/07/18.
 */
data class RssError(val code: Int = 0,
                    var message: String = "") {
    companion object {
        const val ERROR_GENERIC = -1
        const val ERROR_NETWORK = -2

        fun generic() = RssError(code = ERROR_GENERIC)

        fun network() = RssError(code = ERROR_NETWORK)
    }

}