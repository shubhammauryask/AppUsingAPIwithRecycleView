package com.example.api26

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recycleView:RecyclerView
    lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // we call deta
        val recyclerView =findViewById<RecyclerView>(R.id.recycleView)
        val retrofitBulder =  Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apiinterface::class.java)
        // we recive data
        val retrofitData = retrofitBulder.getProductData()

        // press control +shift  + space  in  callback

          retrofitData.enqueue(object : Callback<Mydata?> {

              override fun onResponse(call: Call<Mydata?>, response: Response<Mydata?>) {
                  // if api  call is success then , use the data of api and show your app
                  val responseBody = response.body()  //we get the four value  there
                  val productList = responseBody?.products!!  //we get the list  of products

                  myAdapter = MyAdapter(this@MainActivity,productList)

                  recyclerView.adapter = myAdapter

                  recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
              }

              override fun onFailure(call: Call<Mydata?>, t: Throwable) {
                  //if api call fail then , what

                  Log.d("MainActivity", "onFailure:"+t.message) // use log cat why this fail using massage

              }
          })
    }
}