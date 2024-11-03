package com.example.appcontroller

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.appcontroller.data.ProductSave
import com.example.appcontroller.models.Product
import com.example.appcontroller.models.ProductAdapter
import com.example.appcontroller.models.ProductAux
import com.example.appcontroller.models.ProductCarouselAdapter
import com.example.appcontroller.models.User
import com.example.appcontroller.shared.ToastStyle

class CadProdActivity : ComponentActivity() {
    private lateinit var user: User
    private lateinit var product: Product
    private lateinit var productSave: ProductSave

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cad_prod)
        user = (intent.getSerializableExtra("CURRENT_USER") as? User)!!

        productSave = ProductSave(this)

        val textCod: EditText = findViewById(R.id.cod)
        val textName: EditText = findViewById(R.id.name)
        val textPrice: EditText = findViewById(R.id.price)
        val textProduct: TextView = findViewById(R.id.text_data)

        textName.visibility = View.GONE
        textPrice.visibility = View.GONE
        textProduct.visibility = View.GONE

        val btSave: Button = findViewById(R.id.bt_save)
        val btDel: Button = findViewById(R.id.bt_del)
        val btFind: ImageButton = findViewById(R.id.bt_find)
        val btBack: Button = findViewById(R.id.bt_back)

        btSave.visibility = View.GONE
        btDel.visibility = View.GONE

        val frame1: LinearLayout = findViewById(R.id.frame1)
        val frame2: LinearLayout = findViewById(R.id.frame2)
        val frame3: LinearLayout = findViewById(R.id.frame3)

        frame3.visibility = View.GONE

        textCod.setOnKeyListener { _, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val text = textCod.text.toString()
                val number = text.toIntOrNull()

                if (number != null) {
                    val product = productSave.getProductById(number)

                    if (product != null) {
                        textCod.isEnabled = false
                        btFind.isEnabled = false
                        textName.visibility = View.VISIBLE
                        textPrice.visibility = View.VISIBLE
                        textProduct.visibility = View.VISIBLE
                        btSave.visibility = View.VISIBLE
                        btDel.visibility = View.VISIBLE

                        textName.setText(product.name)
                        textPrice.setText(product.price.toString())

                    } else if (number == 0) {
                        textCod.isEnabled = false
                        btFind.isEnabled = false
                        textName.visibility = View.VISIBLE
                        textPrice.visibility = View.VISIBLE
                        textProduct.visibility = View.VISIBLE
                        btSave.visibility = View.VISIBLE
                        btDel.visibility = View.VISIBLE
                    } else {
                        val toastStyle = ToastStyle(this)
                        toastStyle.showCustomToast("Código não Encontrado", 5000)
                    }
                } else {
                    val toastStyle = ToastStyle(this)
                    toastStyle.showCustomToast("Código Incorreto", 5000)
                }
                true
            } else {
                false
            }
        }

        btSave.setOnClickListener {
            val name = textName.text.toString()
            val priceText = textPrice.text.toString()
            val price = priceText.toDoubleOrNull()
            val cod = textCod.text.toString().toIntOrNull()

            if (name.isNotEmpty()) {
                if (price != null && price != 0.00) {
                    val product = cod?.let { it1 -> productSave.getProductById(it1) }

                    if (product != null) {
                        val update = productSave.updateProduct(cod, name, price)
                        if (update){
                            textCod.isEnabled = true
                            btFind.isEnabled = true
                            textName.visibility = View.GONE
                            textPrice.visibility = View.GONE
                            textProduct.visibility = View.GONE
                            btSave.visibility = View.GONE
                            btDel.visibility = View.GONE

                            textName.setText("")
                            textCod.text = null
                            textPrice.text = null

                            val toastStyle = ToastStyle(this)
                            toastStyle.showCustomToast("Produto Atualizado com Sucesso", 5000)
                        }else{
                            val toastStyle = ToastStyle(this)
                            toastStyle.showCustomToast("Erro no atualizar Produto", 5000)
                        }
                    }else{
                        val insert = productSave.insertProduct(name, price)
                        if (insert) {
                            textCod.isEnabled = true
                            btFind.isEnabled = true
                            textName.visibility = View.GONE
                            textPrice.visibility = View.GONE
                            textProduct.visibility = View.GONE
                            btSave.visibility = View.GONE
                            btDel.visibility = View.GONE

                            textName.setText("")
                            textCod.text = null
                            textPrice.text = null

                            val toastStyle = ToastStyle(this)
                            toastStyle.showCustomToast("Inserido com Sucesso", 5000)

                        } else {
                            val toastStyle = ToastStyle(this)
                            toastStyle.showCustomToast("Já existe um produto com essa descrição", 5000)
                        }
                    }
                } else {
                    val toastStyle = ToastStyle(this)
                    toastStyle.showCustomToast("Preço Incorreto", 5000)
                }
            } else {
                val toastStyle = ToastStyle(this)
                toastStyle.showCustomToast("Nome Incorreto", 5000)
            }
        }

        btDel.setOnClickListener {
            val cod = textCod.text.toString().toIntOrNull()
            val delete = cod?.let { it1 -> productSave.deleteProduct(it1) }
            if (delete == true){
                textCod.isEnabled = true
                btFind.isEnabled = true
                textName.visibility = View.GONE
                textPrice.visibility = View.GONE
                textProduct.visibility = View.GONE
                btSave.visibility = View.GONE
                btDel.visibility = View.GONE

                textName.setText("")
                textCod.text = null
                textPrice.text = null

                val toastStyle = ToastStyle(this)
                toastStyle.showCustomToast("Produto Excluido Com Sucesso", 5000)
            }else{
                textCod.isEnabled = true
                btFind.isEnabled = true
                textName.visibility = View.GONE
                textPrice.visibility = View.GONE
                textProduct.visibility = View.GONE
                btSave.visibility = View.GONE
                btDel.visibility = View.GONE

                textName.setText("")
                textCod.text = null
                textPrice.text = null

                val toastStyle = ToastStyle(this)
                toastStyle.showCustomToast("Novo Cadastro Cancelado", 5000)
            }
        }

        btFind.setOnClickListener{
            frame1.visibility = View.GONE
            frame2.visibility = View.GONE
            frame3.visibility = View.VISIBLE
        }

        btBack.setOnClickListener {
            frame1.visibility = View.VISIBLE
            frame2.visibility = View.VISIBLE
            frame3.visibility = View.GONE
        }

        val viewPager = findViewById<ViewPager2>(R.id.view_pager)

        val products = productSave.getProducts()
        viewPager.adapter = products?.let { ProductAdapter(it) }
    }
}