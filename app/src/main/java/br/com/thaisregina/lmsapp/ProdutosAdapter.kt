package br.com.thaisregina.lmsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.login.*

class ProdutosAdapter(
        val produtos: List<Produtos>,
        val onClick: (Produtos) -> Unit
) : RecyclerView.Adapter<ProdutosAdapter.ProdutosViewHolder>() {
    class ProdutosViewHolder (view: View): RecyclerView.ViewHolder(view){
        val cardNome: TextView
        val cardImg: ImageView
//        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImg = view.findViewById(R.id.card_img)
//            cardProgress = view.findViewById(R.id.card_progresso)
            cardView = view.findViewById(R.id.card_disciplina)
        }


    }

    override fun getItemCount() = this.produtos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produtos, parent, false)

        val holder = ProdutosViewHolder(view)

        return  holder
    }

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {

        val produto = this.produtos[position]

        holder.cardNome.text = produto.nome
//        holder.cardProgress.visibility = View.VISIBLE
        holder.cardImg.setImageResource(R.drawable.produto3)
        holder.itemView.setOnClickListener{ onClick(produto) }
    }
}