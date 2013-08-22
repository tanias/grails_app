package grails_app

class Micropost {
String content
static belongsTo = [author: Author]
    static constraints = {
    }
}
