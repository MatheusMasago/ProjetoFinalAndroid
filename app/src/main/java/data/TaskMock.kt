package data

import model.Tasks

class TaskMock {
    var listaTarefas = ArrayList<Tasks>()

    init {

        for (i in 1..10) {
         listaTarefas.add(Tasks(i,i.toString()))
        }
    }
}