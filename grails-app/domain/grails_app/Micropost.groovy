package grails_app

class Micropost {
String content
static belongsTo = [user: User]
    static constraints = {
    }
}
