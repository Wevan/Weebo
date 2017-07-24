package com.example.wean.weebo.gson;

/**
 * Created by Wean on 2017/7/16.
 */

public class Token {
        private String access_token;

        private int expires_in;

        private String remind_in;

        private String uid;

        public void setAccess_token(String access_token){
            this.access_token = access_token;
        }
        public String getAccess_token(){
            return this.access_token;
        }
        public void setExpires_in(int expires_in){
            this.expires_in = expires_in;
        }
        public int getExpires_in(){
            return this.expires_in;
        }
        public void setRemind_in(String remind_in){
            this.remind_in = remind_in;
        }
        public String getRemind_in(){
            return this.remind_in;
        }
        public void setUid(String uid){
            this.uid = uid;
        }
        public String getUid(){
            return this.uid;
        }

}
