package grails_app

import org.springframework.dao.DataIntegrityViolationException

class MicropostController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [micropostInstanceList: Micropost.list(params), micropostInstanceTotal: Micropost.count()]
    }

    def create() {
        [micropostInstance: new Micropost(params)]
    }
	def createTest(){
		def i = Integer.parseInt(params.recCount)
		while( i > 0 ) {
			def author = new Author()
			author.name = "A${i}"
			author.email = "A${i}@testmail.com"
			author.save()
			def micropost= new Micropost()
			micropost.content="text${1}"
			micropost.author=author
			micropost.save()
			i = i - 1
		}
		redirect(action: "list")
	}
    def save() {
        def micropostInstance = new Micropost(params)
        if (!micropostInstance.save(flush: true)) {
            render(view: "create", model: [micropostInstance: micropostInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'micropost.label', default: 'Micropost'), micropostInstance.id])
        redirect(action: "show", id: micropostInstance.id)
    }

    def show(Long id) {
        def micropostInstance = Micropost.get(id)
        if (!micropostInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'micropost.label', default: 'Micropost'), id])
            redirect(action: "list")
            return
        }

        [micropostInstance: micropostInstance]
    }

    def edit(Long id) {
        def micropostInstance = Micropost.get(id)
        if (!micropostInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'micropost.label', default: 'Micropost'), id])
            redirect(action: "list")
            return
        }

        [micropostInstance: micropostInstance]
    }

    def update(Long id, Long version) {
        def micropostInstance = Micropost.get(id)
        if (!micropostInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'micropost.label', default: 'Micropost'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (micropostInstance.version > version) {
                micropostInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'micropost.label', default: 'Micropost')] as Object[],
                          "Another user has updated this Micropost while you were editing")
                render(view: "edit", model: [micropostInstance: micropostInstance])
                return
            }
        }

        micropostInstance.properties = params

        if (!micropostInstance.save(flush: true)) {
            render(view: "edit", model: [micropostInstance: micropostInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'micropost.label', default: 'Micropost'), micropostInstance.id])
        redirect(action: "show", id: micropostInstance.id)
    }

    def delete(Long id) {
        def micropostInstance = Micropost.get(id)
        if (!micropostInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'micropost.label', default: 'Micropost'), id])
            redirect(action: "list")
            return
        }

        try {
            micropostInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'micropost.label', default: 'Micropost'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'micropost.label', default: 'Micropost'), id])
            redirect(action: "show", id: id)
        }
    }
}
