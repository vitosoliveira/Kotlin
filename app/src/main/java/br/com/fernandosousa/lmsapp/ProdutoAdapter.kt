package br.com.fernandosousa.lmsapp

import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
//import com.picasso.Picasso
import  kotlinx.android.synthetic.main.adapter_produto.*

// define o construtor que recebe a lista de disciplinas e o evento de clique
class ProdutoAdapter (
        val produtos: List<Produto>,
        val onClick: (Produto) -> Unit): RecyclerView.Adapter<ProdutoAdapter.ProdutosViewHolder>() {

    // ViewHolder com os elemetos da tela
    class ProdutosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImg : ImageView
        var cardProgress: ProgressBar
        var cardView: CardView

        init {
            cardNome = view.findViewById<TextView>(R.id.cardNome)
            cardImg = view.findViewById<ImageView>(R.id.cardImg)
            cardProgress = view.findViewById<ProgressBar>(R.id.cardProgress)
            cardView = view.findViewById<CardView>(R.id.card_produtos)

        }

    }

    // Quantidade de disciplinas na lista

    override fun getItemCount() = this.produtos.size

    // inflar layout do adapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutosViewHolder {
        // infla view no adapter
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_produto, parent, false)

        // retornar ViewHolder
        val holder = ProdutosViewHolder(view)
        return holder
    }

    // bind para atualizar Views com os dados

    override fun onBindViewHolder(holder: ProdutosViewHolder, position: Int) {
        val context = holder.itemView.context

        // recuperar objeto disciplina
        val produtos = produtos[position]

        // atualizar dados de disciplina

        holder.cardNome.text = produtos.nome
        holder.cardProgress.visibility = View.VISIBLE

        // download da imagem
//        Picasso.with(context).load(produtos.foto).fit().into(holder.cardImg,
//                object: com.squareup.picasso.Callback{
//                    override fun onSuccess() {
//                        holder.cardProgress.visibility = View.GONE
//                    }
//
//                    override fun onError() {
//                        holder.cardProgress.visibility = View.GONE
//                    }
//                })

        // adiciona evento de clique
        holder.itemView.setOnClickListener {onClick(produtos)}
    }
}