package pub.willow.a.baseservice.redis;

import redis.clients.jedis.ShardedJedis;
/**
 * Redis数据源设置
 * @author kimfu
 *
 */
public interface RedisDataSource {
	/**
	 * 获得Redis客户端接口
	 * @return
	 */
	 public abstract ShardedJedis getRedisClient();
	 /**
	  * 释放连接池
	  * @param shardedJedis
	  */
	 public void returnResource(ShardedJedis shardedJedis);
	 /**
	  * 释放连接池
	  * @param shardedJedis
	  * @param broken - true:强行释放(出错情况需要强行释放),false:默认释放连接池
	  */
	 public void returnResource(ShardedJedis shardedJedis,boolean broken);
}
