package Data

import Model.Task

class TasksMock() {
    var taskList = ArrayList<Task>()
    init {
        for (i in 0 .. 10){
            taskList.add(Task(i.toString()))
        }
    }
}