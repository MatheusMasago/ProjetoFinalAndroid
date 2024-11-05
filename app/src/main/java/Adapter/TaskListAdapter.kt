package Adapter

import Model.Task
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalandroid.R

class TaskListAdapter(val taskList: ArrayList<Task>, val onClickListener: OnClickListener): RecyclerView.Adapter<TaskListAdapter.TaskListHolder>() {
    class TaskListHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val textView: TextView = itemView.findViewById(R.id.tv_mock)
    }
    class OnClickListener(val onClickListener: (Task: Task) -> Unit){
        fun onClick(task: Task) = onClickListener(task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_shop_list, parent, false)

        return TaskListHolder(view)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    override fun onBindViewHolder(holder: TaskListHolder, position: Int) {
        val task = taskList[position]

        holder.textView.setText(task.tarefa)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(task)
        }
    }
}