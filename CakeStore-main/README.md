

<table>
  <tr>
<td> <img width="313" alt="Screenshot 2021-08-01 at 21 35 45" src="https://user-images.githubusercontent.com/26028054/127784921-f8603da2-a1b6-48d7-a028-0e848db67982.png">
    </td>
   <td> <img width="313" alt="Screenshot 2021-08-01 at 21 35 56" src="https://user-images.githubusercontent.com/26028054/127784905-e27ac86b-bfec-49ca-8e61-869b0d509625.png">
   </td>
    <td> <img width="358" alt="Screenshot 2021-08-01 at 22 11 51" src="https://user-images.githubusercontent.com/26028054/127785469-ce306d3b-aa41-45a6-967f-8b67601f3086.png">
    </td>
    <td> <img width="413" alt="Screenshot 2021-08-01 at 22 11 11" src="https://user-images.githubusercontent.com/26028054/127785460-c2b14820-7fc8-4317-897f-5cc99a4588c9.png">
    </td>
    </tr>
 </table>
# CakeStore
# Project Structure

# Coroutines

|--viewmodel -> CharacterListViewModel -Used Coroutines launch for call API service and insert data into local database in a background thread.
|--MyApplication - To start Workmanager job and run in the background thread.

# ViewModel

|--viewmodel ->CharacterListViewModel - It is preparing and managing data for display Characterlist, search and filter.
|--viewmodel ->CharacterDetailViewModel - It is preparing and managing data for display selected character details.

# ViewBinding/DataBinding

|--CharacterList_Fragment - ViewBinding has been used here for resource layout, recyclerView and searchView.
Databinding has been used for bind UI components of row_characters.xml and fragment_chardetail.xml with data source.

# Retrofit2

|--di -> NetworkModule - Retrofit has been used to perform network calls
# GSON

|--di -> NetworkModule - Gson has been used for json data parsing.

# Picasso

|--util ->BindingAdapters - Here, Picasso image loading library has been used to load image into imageview.

# Architecture

This app uses MVVM (Model View View-Model) architecture.

<img width="730" alt="Screenshot 2021-08-01 at 21 49 23" src="https://user-images.githubusercontent.com/26028054/127784943-07325af2-e5ff-4637-b093-7bf4781f7a30.png">

