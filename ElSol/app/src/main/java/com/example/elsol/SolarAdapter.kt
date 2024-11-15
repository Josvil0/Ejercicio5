package com.example.elsol

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class SolarAdapter(
    val solarList: MutableList<SolarItem>
) : RecyclerView.Adapter<SolarAdapter.SolarViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SolarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_solar, parent, false)
        return SolarViewHolder(view)
    }

    override fun onBindViewHolder(holder: SolarViewHolder, position: Int) {
        val solarItem = solarList[position]
        holder.imageViewSolar.setImageResource(solarItem.imageResId)
        holder.toolbar.title = solarItem.name

        // Inflar el menú Overflow
        holder.toolbar.inflateMenu(R.menu.menu_solar_item)

        holder.toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.action_rename -> {
                    // Acción de renombrar
                    showRenameDialog(holder.itemView.context, solarItem)
                    true
                }
                R.id.action_copy -> {
                    // Acción de copiar
                    copyItem(solarItem)
                    true
                }
                R.id.action_cut -> {
                    // Acción de cortar
                    cutItem(solarItem)
                    true
                }
                R.id.action_delete -> {
                    // Acción de eliminar
                    deleteItem(position)
                    true
                }
                R.id.action_move -> {
                    // Acción de mover
                    moveItem(solarItem)
                    true
                }
                else -> false
            }
        }
    }

    override fun getItemCount() = solarList.size

    inner class SolarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewSolar: ImageView = itemView.findViewById(R.id.imageViewSolar)
        val toolbar: androidx.appcompat.widget.Toolbar = itemView.findViewById(R.id.toolbarSolar)
    }

    private fun showRenameDialog(context: Context, solarItem: SolarItem) {
        // Mostrar un cuadro de diálogo para ingresar un nuevo nombre
        val builder = AlertDialog.Builder(context)
        val input = EditText(context)
        input.setText(solarItem.name)
        builder.setView(input)
            .setTitle("Renombrar Sol")
            .setPositiveButton("Renombrar") { _, _ ->
                solarItem.name = input.text.toString()
                notifyItemChanged(solarList.indexOf(solarItem))
            }
            .setNegativeButton("Cancelar", null)
        builder.show()
    }

    private fun copyItem(solarItem: SolarItem) {

        val copiedItem = solarItem.copy()
        solarList.add(copiedItem)
        notifyItemInserted(solarList.size - 1)
    }

    private fun cutItem(solarItem: SolarItem) {
        solarList.remove(solarItem)
        notifyDataSetChanged()
    }

    private fun deleteItem(position: Int) {

        solarList.removeAt(position)
        notifyItemRemoved(position)
    }

    private fun moveItem(solarItem: SolarItem) {
        val currentPosition = solarList.indexOf(solarItem)
        val newPosition = if (currentPosition + 1 < solarList.size) currentPosition + 1 else 0
        solarList.removeAt(currentPosition)
        solarList.add(newPosition, solarItem)
        notifyItemMoved(currentPosition, newPosition)
    }
}
