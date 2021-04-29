# Conference-POC

This is a simple SpringBoot application doing basic CRUD operations on sessions and speakers table while establishing  ManyToMany relationship among them. 

Speaker(Table) - 1. speaker_id LONG
                 2. first_name STRING
                 3. last_name STRING
                 4. title STRING
                 5. company STRING
                 6. speaker_bio STRING
                 
                 
Session(Table) - 1. session_id LONG
                 2. session_name STRING
                 3. session_description STRING
                 4. session_length INT 
                 
                  
Speaker_session(Join Table) - 1. speaker_id INT
                              2. session_id INT
                              3. speaker_session_id INT
