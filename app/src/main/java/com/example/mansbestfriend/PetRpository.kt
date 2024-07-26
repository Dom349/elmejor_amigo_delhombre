package com.example.mansbestfriend


class PetRpository(private val apiservice: APIservise){
        suspend fun GetBreed():List<Breed>{
            return apiservice.GetBreed().breed
        }


    suspend fun getBreedDetails(breed_id:String): Breed {
        return apiservice.getBreedDetails(breed_id).Details
    }

    suspend fun SearchBreedName(breed_id:String): List<Breed> {
        return apiservice.SearchBreedName(breed_id).pets
    }

}

