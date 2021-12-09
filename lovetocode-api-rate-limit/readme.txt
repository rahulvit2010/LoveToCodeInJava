Execution Steps
###############
1.Unzip the lovetocode-api-rate-limit and extract to some loacatiom
2.Import the extracted project  as Existing maven project in Eclipse.
2. right click on ApiRateLimitApplication and run as java application
3. open the postman and hit the below url with header (user-name)
   http://localhost:8080/api/v1/developers
   http://localhost:8019/api/v1/organizations
4- to see rate limit for user+api ,open the h2 console and
   check table rate_limit_config
   h2console url:http://localhost:8019/h2-console
   set jdbc url:jdbc:h2:mem:testdb
5- in case you want to update the rate limit for user or want to add new user 
   with rate limit, then go to data.sql and either change the existing insert 
   query or add new insert query
   
    
Details
########
Info:
--------
This is the Api Rate limiter based on token Bucket Algorithm.
for implementing token bucket algorithm,we have used bucket4j
bucket4j is thread safe and can be used standalone and in clustered
environment(on top of JCache).

how it works:
--------------
Whenever a consumer wants to access an API endpoint, it must get a token 
from the bucket. We remove a token from the bucket if it's available and 
accept the request. On the other hand, we reject a request 
if the bucket doesn't have any tokens.




