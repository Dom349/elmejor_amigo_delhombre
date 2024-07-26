package com.example.mansbestfriend

    import retrofit2.http.GET
    import retrofit2.http.Path
    import retrofit2.http.Query
    import retrofit2.http.Url


    const val BREED_ID = "breed_id"
    const val BREED = "breed/{$BREED_ID}/"
    const val BREED_NAME = "name"

    interface APIservise {
        @GET("message")
        suspend fun GetBreed(@Url url: String): DogResponse

        @GET(BREED)
        suspend fun getBreedDetails(
            @Path(BREED) pet_id: String
        ): DetailsResponse

        @GET(BREED)
        suspend fun SearchBreedName(
            @Query(BREED_NAME) breed_name: String
        ): SearchResponse

}