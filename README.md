# WatsonSoft Messaging

WatsonSoft Messaging is a modular, full-fledged, standalone messaging/chat application. It is
also an importable Android library.

## Architecture
WatsonSoft Messaging makes use of the following [Android Jetpack](https://developer.android.com/jetpack/) components:
* Compose for declarative UI
* Hilt for dependency injection
* Room for internal storage

### Room
Room is used to store messages on local device storage. Entities include the following:
* conversation: Each conversation is composed of a number of messages (1:n)
* messages: each message can only have one sender/user (1:1)
* senders: users capable of sending messages 
