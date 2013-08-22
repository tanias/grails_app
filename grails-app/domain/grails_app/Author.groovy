package grails_app

class Author {
String name
String email
static hasMany = [micropost: Micropost]
    static constraints = {
    }
}
