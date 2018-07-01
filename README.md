# ImageLoading
Implementation of in-memory and file caching of images in an infinite scrollable view.

The project demonstrates usage of

### Flick API
for getting the list of photos and 

### Caching 
Images are cached into disk as well as in memory to save network çalls.
We also cache the search result returned by Flickr in-memory itself.

### Unit tests
The project also demonstrates unit tests.

## Further optimzation (in future)
We could implement few tactics (currently not implemented to further optimize our code) in following ways.

Cancelling the image download request; once the user scrolls ups the view.
Storing search results on disk along with in-memory, for a limited period of time.


