class builderPattern{
    public static void main(String[] args){
        human taro = new human.builder()
                              .setLastName("taro")
                              .setfirstName("yamada")
                              .setId(100)
                              .build();
        System.out.println(taro.getname());
        System.out.println(taro.getid());
        
        human hanako = new human.builder()
                            //   .setLastName("taro")
                            //   .setfirstName("yamada")
                            //   .setId(100)
                              .build();
        System.out.println(hanako.getname());
        System.out.println(hanako.getid());
    }
}

class human{
    private String lastName;
    private int id;
    private String firstName;
    
    public static class builder{
        private String lastName;
        private String firstName;
        private Integer id;
        public builder setLastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public builder setfirstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public builder setId(Integer id){
            this.id = id;
            return this;
        }
        public human build(){
            if(this.lastName == null) this.lastName = "nanasino";
            if(this.firstName == null) this.firstName = "gonbe";
            if(this.id == null) this.id = -1;
            
            
            human h = new human();
            h.lastName = this.lastName;
            h.firstName = this.firstName;
            h.id = this.id;
            return h;
        }
    }
    public String getname(){
        return firstName + " " + lastName;
    }
    public int getid(){
        return id;
    }
}
