import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.transak.sample.R
import com.transak.sample.databinding.ItemKeyValueBinding

class KeyValueAdapter(private val dataList: List<KeyValue>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_key_value, parent, false)
        val itemBinding: ItemKeyValueBinding =
            ItemKeyValueBinding.bind(view)
        return ItemViewHolder(itemBinding)
    }

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]
        val binding = holder as? ItemViewHolder
        binding?.itemBinding?.run {
            keyTextView.text = data.key
            valueTextView.text = data.value
        }
    }
}

class ItemViewHolder(itemBinding: ItemKeyValueBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {
    var itemBinding: ItemKeyValueBinding? = null

    init {
        this.itemBinding = itemBinding
    }
}