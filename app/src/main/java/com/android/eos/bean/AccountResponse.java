package com.android.eos.bean;

import java.util.List;

/**
 * Created by luojialun on 2018/11/15.
 */

public class AccountResponse {

    /**
     * account_name : kakasiri2us1
     * head_block_num : 412649
     * head_block_time : 2018-11-15T14:23:26.000
     * privileged : false
     * last_code_update : 1970-01-01T00:00:00.000
     * created : 2018-11-13T05:04:46.500
     * core_liquid_balance : 2000000.0000 EOS
     * ram_quota : 6836
     * net_weight : 3000587435050
     * cpu_weight : 3000587435050
     * net_limit : {"used":241,"available":"110281589871356","max":"110281589871597"}
     * cpu_limit : {"used":1960,"available":"10517271966403","max":"10517271968363"}
     * ram_usage : 3558
     * permissions : [{"perm_name":"active","parent":"owner","required_auth":{"threshold":1,"keys":[{"key":"EOS6E1PAdPV7pXKyJ5gjRnEGfVdVhwMoEGgtmgR1FUyVNbmu4feCK","weight":1}],"accounts":[],"waits":[]}},{"perm_name":"owner","parent":"","required_auth":{"threshold":1,"keys":[{"key":"EOS6E1PAdPV7pXKyJ5gjRnEGfVdVhwMoEGgtmgR1FUyVNbmu4feCK","weight":1}],"accounts":[],"waits":[]}}]
     * total_resources : {"owner":"kakasiri2us1","net_weight":"300058743.5050 EOS","cpu_weight":"300058743.5050 EOS","ram_bytes":6836}
     * self_delegated_bandwidth : {"from":"kakasiri2us1","to":"kakasiri2us1","net_weight":"300058743.5050 EOS","cpu_weight":"300058743.5050 EOS"}
     * refund_request : null
     * voter_info : {"owner":"kakasiri2us1","proxy":"kakasiri2bpa","producers":[],"staked":"6001174870100","last_vote_weight":"2982977970613313536.00000000000000000","proxied_vote_weight":"0.00000000000000000","is_proxy":0}
     */

    private String account_name;
    private int head_block_num;
    private String head_block_time;
    private boolean privileged;
    private String last_code_update;
    private String created;
    private String core_liquid_balance;
    private int ram_quota;
    private String net_weight;
    private String cpu_weight;
    private NetLimitBean net_limit;
    private CpuLimitBean cpu_limit;
    private int ram_usage;
    private TotalResourcesBean total_resources;
    private SelfDelegatedBandwidthBean self_delegated_bandwidth;
    private Object refund_request;
    private VoterInfoBean voter_info;
    private List<PermissionsBean> permissions;

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public int getHead_block_num() {
        return head_block_num;
    }

    public void setHead_block_num(int head_block_num) {
        this.head_block_num = head_block_num;
    }

    public String getHead_block_time() {
        return head_block_time;
    }

    public void setHead_block_time(String head_block_time) {
        this.head_block_time = head_block_time;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public String getLast_code_update() {
        return last_code_update;
    }

    public void setLast_code_update(String last_code_update) {
        this.last_code_update = last_code_update;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCore_liquid_balance() {
        return core_liquid_balance;
    }

    public void setCore_liquid_balance(String core_liquid_balance) {
        this.core_liquid_balance = core_liquid_balance;
    }

    public int getRam_quota() {
        return ram_quota;
    }

    public void setRam_quota(int ram_quota) {
        this.ram_quota = ram_quota;
    }

    public String getNet_weight() {
        return net_weight;
    }

    public void setNet_weight(String net_weight) {
        this.net_weight = net_weight;
    }

    public String getCpu_weight() {
        return cpu_weight;
    }

    public void setCpu_weight(String cpu_weight) {
        this.cpu_weight = cpu_weight;
    }

    public NetLimitBean getNet_limit() {
        return net_limit;
    }

    public void setNet_limit(NetLimitBean net_limit) {
        this.net_limit = net_limit;
    }

    public CpuLimitBean getCpu_limit() {
        return cpu_limit;
    }

    public void setCpu_limit(CpuLimitBean cpu_limit) {
        this.cpu_limit = cpu_limit;
    }

    public int getRam_usage() {
        return ram_usage;
    }

    public void setRam_usage(int ram_usage) {
        this.ram_usage = ram_usage;
    }

    public TotalResourcesBean getTotal_resources() {
        return total_resources;
    }

    public void setTotal_resources(TotalResourcesBean total_resources) {
        this.total_resources = total_resources;
    }

    public SelfDelegatedBandwidthBean getSelf_delegated_bandwidth() {
        return self_delegated_bandwidth;
    }

    public void setSelf_delegated_bandwidth(SelfDelegatedBandwidthBean self_delegated_bandwidth) {
        this.self_delegated_bandwidth = self_delegated_bandwidth;
    }

    public Object getRefund_request() {
        return refund_request;
    }

    public void setRefund_request(Object refund_request) {
        this.refund_request = refund_request;
    }

    public VoterInfoBean getVoter_info() {
        return voter_info;
    }

    public void setVoter_info(VoterInfoBean voter_info) {
        this.voter_info = voter_info;
    }

    public List<PermissionsBean> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionsBean> permissions) {
        this.permissions = permissions;
    }

    public static class NetLimitBean {
        /**
         * used : 241
         * available : 110281589871356
         * max : 110281589871597
         */

        private int used;
        private String available;
        private String max;

        public int getUsed() {
            return used;
        }

        public void setUsed(int used) {
            this.used = used;
        }

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
        }

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }
    }

    public static class CpuLimitBean {
        /**
         * used : 1960
         * available : 10517271966403
         * max : 10517271968363
         */

        private int used;
        private String available;
        private String max;

        public int getUsed() {
            return used;
        }

        public void setUsed(int used) {
            this.used = used;
        }

        public String getAvailable() {
            return available;
        }

        public void setAvailable(String available) {
            this.available = available;
        }

        public String getMax() {
            return max;
        }

        public void setMax(String max) {
            this.max = max;
        }
    }

    public static class TotalResourcesBean {
        /**
         * owner : kakasiri2us1
         * net_weight : 300058743.5050 EOS
         * cpu_weight : 300058743.5050 EOS
         * ram_bytes : 6836
         */

        private String owner;
        private String net_weight;
        private String cpu_weight;
        private int ram_bytes;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getNet_weight() {
            return net_weight;
        }

        public void setNet_weight(String net_weight) {
            this.net_weight = net_weight;
        }

        public String getCpu_weight() {
            return cpu_weight;
        }

        public void setCpu_weight(String cpu_weight) {
            this.cpu_weight = cpu_weight;
        }

        public int getRam_bytes() {
            return ram_bytes;
        }

        public void setRam_bytes(int ram_bytes) {
            this.ram_bytes = ram_bytes;
        }
    }

    public static class SelfDelegatedBandwidthBean {
        /**
         * from : kakasiri2us1
         * to : kakasiri2us1
         * net_weight : 300058743.5050 EOS
         * cpu_weight : 300058743.5050 EOS
         */

        private String from;
        private String to;
        private String net_weight;
        private String cpu_weight;

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

        public String getNet_weight() {
            return net_weight;
        }

        public void setNet_weight(String net_weight) {
            this.net_weight = net_weight;
        }

        public String getCpu_weight() {
            return cpu_weight;
        }

        public void setCpu_weight(String cpu_weight) {
            this.cpu_weight = cpu_weight;
        }
    }

    public static class VoterInfoBean {
        /**
         * owner : kakasiri2us1
         * proxy : kakasiri2bpa
         * producers : []
         * staked : 6001174870100
         * last_vote_weight : 2982977970613313536.00000000000000000
         * proxied_vote_weight : 0.00000000000000000
         * is_proxy : 0
         */

        private String owner;
        private String proxy;
        private String staked;
        private String last_vote_weight;
        private String proxied_vote_weight;
        private int is_proxy;
        private List<?> producers;

        public String getOwner() {
            return owner;
        }

        public void setOwner(String owner) {
            this.owner = owner;
        }

        public String getProxy() {
            return proxy;
        }

        public void setProxy(String proxy) {
            this.proxy = proxy;
        }

        public String getStaked() {
            return staked;
        }

        public void setStaked(String staked) {
            this.staked = staked;
        }

        public String getLast_vote_weight() {
            return last_vote_weight;
        }

        public void setLast_vote_weight(String last_vote_weight) {
            this.last_vote_weight = last_vote_weight;
        }

        public String getProxied_vote_weight() {
            return proxied_vote_weight;
        }

        public void setProxied_vote_weight(String proxied_vote_weight) {
            this.proxied_vote_weight = proxied_vote_weight;
        }

        public int getIs_proxy() {
            return is_proxy;
        }

        public void setIs_proxy(int is_proxy) {
            this.is_proxy = is_proxy;
        }

        public List<?> getProducers() {
            return producers;
        }

        public void setProducers(List<?> producers) {
            this.producers = producers;
        }
    }

    public static class PermissionsBean {
        /**
         * perm_name : active
         * parent : owner
         * required_auth : {"threshold":1,"keys":[{"key":"EOS6E1PAdPV7pXKyJ5gjRnEGfVdVhwMoEGgtmgR1FUyVNbmu4feCK","weight":1}],"accounts":[],"waits":[]}
         */

        private String perm_name;
        private String parent;
        private RequiredAuthBean required_auth;

        public String getPerm_name() {
            return perm_name;
        }

        public void setPerm_name(String perm_name) {
            this.perm_name = perm_name;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public RequiredAuthBean getRequired_auth() {
            return required_auth;
        }

        public void setRequired_auth(RequiredAuthBean required_auth) {
            this.required_auth = required_auth;
        }

        public static class RequiredAuthBean {
            /**
             * threshold : 1
             * keys : [{"key":"EOS6E1PAdPV7pXKyJ5gjRnEGfVdVhwMoEGgtmgR1FUyVNbmu4feCK","weight":1}]
             * accounts : []
             * waits : []
             */

            private int threshold;
            private List<KeysBean> keys;
            private List<?> accounts;
            private List<?> waits;

            public int getThreshold() {
                return threshold;
            }

            public void setThreshold(int threshold) {
                this.threshold = threshold;
            }

            public List<KeysBean> getKeys() {
                return keys;
            }

            public void setKeys(List<KeysBean> keys) {
                this.keys = keys;
            }

            public List<?> getAccounts() {
                return accounts;
            }

            public void setAccounts(List<?> accounts) {
                this.accounts = accounts;
            }

            public List<?> getWaits() {
                return waits;
            }

            public void setWaits(List<?> waits) {
                this.waits = waits;
            }

            public static class KeysBean {
                /**
                 * key : EOS6E1PAdPV7pXKyJ5gjRnEGfVdVhwMoEGgtmgR1FUyVNbmu4feCK
                 * weight : 1
                 */

                private String key;
                private int weight;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public int getWeight() {
                    return weight;
                }

                public void setWeight(int weight) {
                    this.weight = weight;
                }
            }
        }
    }
}
