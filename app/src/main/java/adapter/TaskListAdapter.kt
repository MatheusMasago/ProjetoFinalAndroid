package adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projetofinalandroid.R
import model.Tasks

class TaskListAdapter( val listaTarefas: ArrayList<Tasks>, val onClickListener: OnClickListener): RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {

    class TaskListViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
    val textView: TextView = itemView.findViewById(R.id.tv_model)
    }

    class OnClickListener(val clickListener: (task: Tasks) -> Unit){
        fun onClick(task: Tasks) = clickListener(task)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_task_list, parent, false)
        return TaskListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listaTarefas.size
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val tasks = listaTarefas[position]

        holder.textView.setText(tasks.nome)
        holder.itemView.setOnClickListener{
           onClickListener.onClick(tasks)

        }

    }
}