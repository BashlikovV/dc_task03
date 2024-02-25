package by.bashlikovvv.model

import java.sql.Timestamp

class Tweet(
    val id: Long,
    val editorId: Long,
    val title: String,
    val content: String,
    val created: Timestamp,
    val modified: Timestamp
)