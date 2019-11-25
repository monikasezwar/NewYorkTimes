# NewYorkTimes
first commit

Used MVVM for this project, because this architecture separates business logic from View. It means that model can change without View being aware of that and vice-e-versa. MVVM architecture is easy to maintain, easy to do unit testing and also open for scalability.

Used architectural components like LiveData, Room,ViewModel. 
ViewModel is responsible for manipulating UI-related data, and it remain intact throughout activity lifecycle and don’t even change on rotation. 
Room avoid boilerplate code, provides compile time checks,and also return Observables, Flowables, LiveData which is not possible with SQLite

Used third party library Picasso to bind images from URL

Used ListView as well as RecyclerView.

Used coroutines to do asynchronous network calls.

