package uz.teda.onlineshop.screen

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.teda.onlineshop.api.Api
import uz.teda.onlineshop.model.BaseResponse
import uz.teda.onlineshop.model.CategoryModel
import uz.teda.onlineshop.model.OfferModel
import uz.teda.onlineshop.screen.view.CategoryAdapter

class MainViewModel : ViewModel() {

    val error = MutableLiveData<String>()
    val offersData = MutableLiveData<List<OfferModel>>()
    val categoriesDate = MutableLiveData<List<CategoryModel>>()

    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://osonsavdo.sd-group.uz/api/")
        .build()
    val api = retrofit.create(Api::class.java)

    fun getOffers() {
        api.getOffers().enqueue(object : Callback<BaseResponse<List<OfferModel>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<OfferModel>>>,
                response: Response<BaseResponse<List<OfferModel>>>
            ) {
                if (response.isSuccessful && response.body()!!.success) {
                    offersData.value = response.body()!!.data!!

                } else {
                    error.value = response.body()?.message ?: response.message()
                }

            }

            override fun onFailure(call: Call<BaseResponse<List<OfferModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }

        })
    }

    fun getCategories() {
        api.getCategories().enqueue(object : Callback<BaseResponse<List<CategoryModel>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<CategoryModel>>>,
                response: Response<BaseResponse<List<CategoryModel>>>
            ) {
                if (response.isSuccessful && response.body()!!.success) {
                   categoriesDate.value = response.body()!!.data!!
                        } else {
                    error.value = response.body()?.message ?: response.message()
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<CategoryModel>>>, t: Throwable) {
                error.value = t.localizedMessage
            }

        }
        )

    }

}