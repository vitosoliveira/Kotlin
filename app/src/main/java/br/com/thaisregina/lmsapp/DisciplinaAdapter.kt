package br.com.thaisregina.lmsapp

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class DisciplinaAdapter(
        val disciplinas: List<Disciplina>,
        val onClick: (Disciplina) -> Unit
) : RecyclerView.Adapter<DisciplinaAdapter.DisciplinasViewHolder>() {
    class DisciplinasViewHolder (view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
            cardProgress = view.findViewById(R.id.card_progresso)
            cardView = view.findViewById(R.id.card_disciplina)
        }

    }

    override fun getItemCount() = this.disciplinas.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisciplinasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_disciplina, parent, false)

        val holder = DisciplinasViewHolder(view)

        return  holder
    }

    override fun onBindViewHolder(holder: DisciplinasViewHolder, position: Int) {

        val disciplina = this.disciplinas[position]

        holder.cardNome.text = disciplina.nome
        holder.cardProgress.visibility = View.VISIBLE

        holder.itemView.setOnClickListener{ onClick(disciplina) }
    }
}