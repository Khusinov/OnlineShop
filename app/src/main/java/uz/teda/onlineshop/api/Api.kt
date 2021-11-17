package uz.teda.onlineshop.api

import retrofit2.Call
import retrofit2.http.GET
import uz.teda.onlineshop.model.BaseResponse
import uz.teda.onlineshop.model.CategoryModel
import uz.teda.onlineshop.model.OfferModel
import uz.teda.onlineshop.model.TopProductModel

interface Api {
   @GET("get_offers")
   fun getOffers(): Call<BaseResponse<List<OfferModel>>>

   @GET("get_categories")
   fun getCategories():Call<BaseResponse<List<CategoryModel>>>

   @GET("get_top_products")
   fun getTopProducts():Call<BaseResponse<List<TopProductModel>>>

   @GET("get_top")
   fun getTopProduct():Call<BaseResponse<List<TopProductModel>>>
}