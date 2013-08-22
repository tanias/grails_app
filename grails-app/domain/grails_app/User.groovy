package grails_app

class User {
String name
String email
static hasMany = [micropost: Micropost]
    static constraints = {
    }
}
