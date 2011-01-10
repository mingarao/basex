# This example shows how queries can be executed in an iterative manner.
# Documentation: http://basex.org/api
#
# (C) BaseX Team 2005-11, ISC License

require 'BaseXClient.rb'

begin
  # create session
  session = Session.new("localhost", 1984, "admin", "admin")

  begin
    # create query instance
    input = "for $i in 1 to 10 return <xml>Text { $i }</xml>"
    query = session.query(input)
    
    # initializes query
    print query.init
    
    # loop through all results
    while query.more do
      print query.next
    end

    # close query instance
    print query.close()
  
  rescue Exception => e
    # print exception
    puts e
  end

  # close session
  session.close

rescue Exception => e
  # print exception
  puts e
end
