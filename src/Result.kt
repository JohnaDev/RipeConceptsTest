
class SimulateResult{
    fun start(){
        handle(Result.Success("Horray!"))
        handle(Result.Error("Sad"))
        handle(Result.Loading)
    }

    private fun handle(result: Result){
         when (result){
             is Result.Success -> {println(result.data)}
             is Result.Error -> {println(result.message)}
             Result.Loading -> {println("Loading...")}
         }
    }
}

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
    object Loading : Result()
}