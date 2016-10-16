package pub.willow.a.baseservice.redis.impl;

import org.apache.log4j.Logger;

import pub.willow.a.baseservice.redis.RedisDataSource;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisDataSourceImpl implements RedisDataSource {
	
	private static final Logger log = Logger.getLogger("redis");
	
    private ShardedJedisPool  shardedJedisPool;
    
	public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
		this.shardedJedisPool = shardedJedisPool;
	}

	@Override
	public ShardedJedis getRedisClient() {
		try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
        	log.error("getRedisClent error", e);
        	throw new RuntimeException(e);
        }
	}

	@Override
	public void returnResource(ShardedJedis shardedJedis) {
		shardedJedisPool.returnResource(shardedJedis);
	}

	@Override
	public void returnResource(ShardedJedis shardedJedis, boolean broken) {
		if (broken) {
            shardedJedisPool.returnBrokenResource(shardedJedis);				//强行释放
        } else {
            shardedJedisPool.returnResource(shardedJedis);
        }
	}

}
