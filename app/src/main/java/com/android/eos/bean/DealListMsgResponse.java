package com.android.eos.bean;

import java.util.List;

public class DealListMsgResponse {

    /**
     * actions : [{"global_action_seq":42,"account_action_seq":0,"block_num":10,"block_time":"2018-11-13T05:04:46.500","action_trace":{"receipt":{"receiver":"kakasiri2us1","act_digest":"ecb948ec639950536d1cb785bd5a519893a570401e5bf0da3d0df3841ef927b1","global_sequence":42,"recv_sequence":1,"auth_sequence":[["eosio",37]],"code_sequence":1,"abi_sequence":1},"act":{"account":"eosio.token","name":"transfer","authorization":[{"actor":"eosio","permission":"active"}],"data":{"from":"eosio","to":"kakasiri2us1","quantity":"2000000.0000 EOS","memo":""},"hex_data":"0000000000ea305510b016ee3a6ca08100c817a80400000004454f530000000000"},"context_free":false,"elapsed":10,"console":"","trx_id":"f68f8fcb9bfd8cf4397d1375ee171f391597b179fefb6ae2a2330c598d2476df","block_num":10,"block_time":"2018-11-13T05:04:46.500","producer_block_id":null,"account_ram_deltas":[],"except":null,"inline_traces":[]}}]
     * last_irreversible_block : 880694
     */

    private int last_irreversible_block;
    private List<ActionsBean> actions;

    public int getLast_irreversible_block() {
        return last_irreversible_block;
    }

    public void setLast_irreversible_block(int last_irreversible_block) {
        this.last_irreversible_block = last_irreversible_block;
    }

    public List<ActionsBean> getActions() {
        return actions;
    }

    public void setActions(List<ActionsBean> actions) {
        this.actions = actions;
    }

    public static class ActionsBean {
        /**
         * global_action_seq : 42
         * account_action_seq : 0
         * block_num : 10
         * block_time : 2018-11-13T05:04:46.500
         * action_trace : {"receipt":{"receiver":"kakasiri2us1","act_digest":"ecb948ec639950536d1cb785bd5a519893a570401e5bf0da3d0df3841ef927b1","global_sequence":42,"recv_sequence":1,"auth_sequence":[["eosio",37]],"code_sequence":1,"abi_sequence":1},"act":{"account":"eosio.token","name":"transfer","authorization":[{"actor":"eosio","permission":"active"}],"data":{"from":"eosio","to":"kakasiri2us1","quantity":"2000000.0000 EOS","memo":""},"hex_data":"0000000000ea305510b016ee3a6ca08100c817a80400000004454f530000000000"},"context_free":false,"elapsed":10,"console":"","trx_id":"f68f8fcb9bfd8cf4397d1375ee171f391597b179fefb6ae2a2330c598d2476df","block_num":10,"block_time":"2018-11-13T05:04:46.500","producer_block_id":null,"account_ram_deltas":[],"except":null,"inline_traces":[]}
         */

        private int global_action_seq;
        private int account_action_seq;
        private int block_num;
        private String block_time;
        private ActionTraceBean action_trace;

        public int getGlobal_action_seq() {
            return global_action_seq;
        }

        public void setGlobal_action_seq(int global_action_seq) {
            this.global_action_seq = global_action_seq;
        }

        public int getAccount_action_seq() {
            return account_action_seq;
        }

        public void setAccount_action_seq(int account_action_seq) {
            this.account_action_seq = account_action_seq;
        }

        public int getBlock_num() {
            return block_num;
        }

        public void setBlock_num(int block_num) {
            this.block_num = block_num;
        }

        public String getBlock_time() {
            return block_time;
        }

        public void setBlock_time(String block_time) {
            this.block_time = block_time;
        }

        public ActionTraceBean getAction_trace() {
            return action_trace;
        }

        public void setAction_trace(ActionTraceBean action_trace) {
            this.action_trace = action_trace;
        }

        public static class ActionTraceBean {
            /**
             * receipt : {"receiver":"kakasiri2us1","act_digest":"ecb948ec639950536d1cb785bd5a519893a570401e5bf0da3d0df3841ef927b1","global_sequence":42,"recv_sequence":1,"auth_sequence":[["eosio",37]],"code_sequence":1,"abi_sequence":1}
             * act : {"account":"eosio.token","name":"transfer","authorization":[{"actor":"eosio","permission":"active"}],"data":{"from":"eosio","to":"kakasiri2us1","quantity":"2000000.0000 EOS","memo":""},"hex_data":"0000000000ea305510b016ee3a6ca08100c817a80400000004454f530000000000"}
             * context_free : false
             * elapsed : 10
             * console :
             * trx_id : f68f8fcb9bfd8cf4397d1375ee171f391597b179fefb6ae2a2330c598d2476df
             * block_num : 10
             * block_time : 2018-11-13T05:04:46.500
             * producer_block_id : null
             * account_ram_deltas : []
             * except : null
             * inline_traces : []
             */

            private ReceiptBean receipt;
            private ActBean act;
            private boolean context_free;
            private int elapsed;
            private String console;
            private String trx_id;
            private int block_num;
            private String block_time;
            private Object producer_block_id;
            private Object except;
            private List<?> account_ram_deltas;
            private List<?> inline_traces;

            public ReceiptBean getReceipt() {
                return receipt;
            }

            public void setReceipt(ReceiptBean receipt) {
                this.receipt = receipt;
            }

            public ActBean getAct() {
                return act;
            }

            public void setAct(ActBean act) {
                this.act = act;
            }

            public boolean isContext_free() {
                return context_free;
            }

            public void setContext_free(boolean context_free) {
                this.context_free = context_free;
            }

            public int getElapsed() {
                return elapsed;
            }

            public void setElapsed(int elapsed) {
                this.elapsed = elapsed;
            }

            public String getConsole() {
                return console;
            }

            public void setConsole(String console) {
                this.console = console;
            }

            public String getTrx_id() {
                return trx_id;
            }

            public void setTrx_id(String trx_id) {
                this.trx_id = trx_id;
            }

            public int getBlock_num() {
                return block_num;
            }

            public void setBlock_num(int block_num) {
                this.block_num = block_num;
            }

            public String getBlock_time() {
                return block_time;
            }

            public void setBlock_time(String block_time) {
                this.block_time = block_time;
            }

            public Object getProducer_block_id() {
                return producer_block_id;
            }

            public void setProducer_block_id(Object producer_block_id) {
                this.producer_block_id = producer_block_id;
            }

            public Object getExcept() {
                return except;
            }

            public void setExcept(Object except) {
                this.except = except;
            }

            public List<?> getAccount_ram_deltas() {
                return account_ram_deltas;
            }

            public void setAccount_ram_deltas(List<?> account_ram_deltas) {
                this.account_ram_deltas = account_ram_deltas;
            }

            public List<?> getInline_traces() {
                return inline_traces;
            }

            public void setInline_traces(List<?> inline_traces) {
                this.inline_traces = inline_traces;
            }

            public static class ReceiptBean {
                /**
                 * receiver : kakasiri2us1
                 * act_digest : ecb948ec639950536d1cb785bd5a519893a570401e5bf0da3d0df3841ef927b1
                 * global_sequence : 42
                 * recv_sequence : 1
                 * auth_sequence : [["eosio",37]]
                 * code_sequence : 1
                 * abi_sequence : 1
                 */

                private String receiver;
                private String act_digest;
                private int global_sequence;
                private int recv_sequence;
                private int code_sequence;
                private int abi_sequence;
                private List<List<String>> auth_sequence;

                public String getReceiver() {
                    return receiver;
                }

                public void setReceiver(String receiver) {
                    this.receiver = receiver;
                }

                public String getAct_digest() {
                    return act_digest;
                }

                public void setAct_digest(String act_digest) {
                    this.act_digest = act_digest;
                }

                public int getGlobal_sequence() {
                    return global_sequence;
                }

                public void setGlobal_sequence(int global_sequence) {
                    this.global_sequence = global_sequence;
                }

                public int getRecv_sequence() {
                    return recv_sequence;
                }

                public void setRecv_sequence(int recv_sequence) {
                    this.recv_sequence = recv_sequence;
                }

                public int getCode_sequence() {
                    return code_sequence;
                }

                public void setCode_sequence(int code_sequence) {
                    this.code_sequence = code_sequence;
                }

                public int getAbi_sequence() {
                    return abi_sequence;
                }

                public void setAbi_sequence(int abi_sequence) {
                    this.abi_sequence = abi_sequence;
                }

                public List<List<String>> getAuth_sequence() {
                    return auth_sequence;
                }

                public void setAuth_sequence(List<List<String>> auth_sequence) {
                    this.auth_sequence = auth_sequence;
                }
            }

            public static class ActBean {
                /**
                 * account : eosio.token
                 * name : transfer
                 * authorization : [{"actor":"eosio","permission":"active"}]
                 * data : {"from":"eosio","to":"kakasiri2us1","quantity":"2000000.0000 EOS","memo":""}
                 * hex_data : 0000000000ea305510b016ee3a6ca08100c817a80400000004454f530000000000
                 */

                private String account;
                private String name;
                private DataBean data;
                private String hex_data;
                private List<AuthorizationBean> authorization;

                public String getAccount() {
                    return account;
                }

                public void setAccount(String account) {
                    this.account = account;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public DataBean getData() {
                    return data;
                }

                public void setData(DataBean data) {
                    this.data = data;
                }

                public String getHex_data() {
                    return hex_data;
                }

                public void setHex_data(String hex_data) {
                    this.hex_data = hex_data;
                }

                public List<AuthorizationBean> getAuthorization() {
                    return authorization;
                }

                public void setAuthorization(List<AuthorizationBean> authorization) {
                    this.authorization = authorization;
                }

                public static class DataBean {
                    /**
                     * from : eosio
                     * to : kakasiri2us1
                     * quantity : 2000000.0000 EOS
                     * memo :
                     */

                    private String from;
                    private String to;
                    private String quantity;
                    private String memo;

                    public String getFrom() {
                        return from;
                    }

                    public void setFrom(String from) {
                        this.from = from;
                    }

                    public String getTo() {
                        return to;
                    }

                    public void setTo(String to) {
                        this.to = to;
                    }

                    public String getQuantity() {
                        return quantity;
                    }

                    public void setQuantity(String quantity) {
                        this.quantity = quantity;
                    }

                    public String getMemo() {
                        return memo;
                    }

                    public void setMemo(String memo) {
                        this.memo = memo;
                    }
                }

                public static class AuthorizationBean {
                    /**
                     * actor : eosio
                     * permission : active
                     */

                    private String actor;
                    private String permission;

                    public String getActor() {
                        return actor;
                    }

                    public void setActor(String actor) {
                        this.actor = actor;
                    }

                    public String getPermission() {
                        return permission;
                    }

                    public void setPermission(String permission) {
                        this.permission = permission;
                    }
                }
            }
        }
    }
}
