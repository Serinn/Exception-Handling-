# Exception-Handling-

In logging, one log file is needed to be produced based on the message receieved from the user/s. Suppose that there are more than one client applications are using this logging class, then it is possible for them to create more than one instance of the class. This might cause some issues during concurrent access to the same ligger file. Since singleton allows us to create only one instance of the class, then it might be very useful and will prevent such issues to happen. In this way, we can guaratee that there is no more than one user is accessing the logging file at the same time. That's why singleton is most likely to be used in logging.
