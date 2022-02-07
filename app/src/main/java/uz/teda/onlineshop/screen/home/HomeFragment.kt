package uz.teda.onlineshop.screen.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.teda.onlineshop.R
import uz.teda.onlineshop.api.Api
import uz.teda.onlineshop.model.BaseResponse
import uz.teda.onlineshop.model.CategoryModel
import uz.teda.onlineshop.model.OfferModel
import uz.teda.onlineshop.screen.MainViewModel
import uz.teda.onlineshop.screen.view.CategoryAdapter

class HomeFragment : Fragment() {

    var offers: List<OfferModel> = emptyList()
    lateinit var viewModel:MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerCategories.layoutManager = LinearLayoutManager(requireActivity() , LinearLayoutManager.HORIZONTAL , false)

        viewModel.error.observe( requireActivity() , Observer {
            Toast.makeText(requireActivity() , it, Toast.LENGTH_LONG).show()
        } )

        viewModel.offersData.observe(requireActivity() , Observer {
            carouselView.setImageListener { position, imageView ->
                Glide.with(imageView)
                    .load("http://osonsavdo.sd-group.uz/images/${it[position].image}")
                    .into(imageView)
            }
            carouselView.pageCount = it.size
        })
        
       loadData()

    }

    fun loadData(){
        viewModel.getOffers()
        viewModel.getCategories()
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}