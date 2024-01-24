package io.github.ungman.tarantooldemo.config;

import io.github.ungman.tarantooldemo.repo.UserRepository;
import io.tarantool.driver.api.TarantoolClient;
import io.tarantool.driver.api.TarantoolClientConfig;
import io.tarantool.driver.api.TarantoolClientFactory;
import io.tarantool.driver.api.TarantoolClusterAddressProvider;
import io.tarantool.driver.api.TarantoolResult;
import io.tarantool.driver.api.TarantoolServerAddress;
import io.tarantool.driver.api.tuple.TarantoolTuple;
import io.tarantool.driver.auth.SimpleTarantoolCredentials;
import io.tarantool.driver.auth.TarantoolCredentials;
import io.tarantool.driver.core.ProxyTarantoolTupleClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.tarantool.config.AbstractTarantoolDataConfiguration;
import org.springframework.data.tarantool.repository.config.EnableTarantoolRepositories;

@Configuration
@EnableTarantoolRepositories(basePackageClasses = {UserRepository.class})
public class TarantoolConfiguration extends AbstractTarantoolDataConfiguration {

	@Value("${tarantool.host}")
	protected String host;

	@Value("${tarantool.port}")
	protected int port;

	@Value("${tarantool.username}")
	protected String username;

	@Value("${tarantool.password}")
	protected String password;

	@Override
	public TarantoolCredentials tarantoolCredentials() {
		return new SimpleTarantoolCredentials(username, password);
	}

	@Override
	protected TarantoolServerAddress tarantoolServerAddress() {
		return new TarantoolServerAddress(host, port);
	}
	@Override
	public TarantoolClient<TarantoolTuple, TarantoolResult<TarantoolTuple>> tarantoolClient(
			TarantoolClientConfig tarantoolClientConfig,
			TarantoolClusterAddressProvider tarantoolClusterAddressProvider) {
		return TarantoolClientFactory.createClient()
				.withAddress(host,  port)
				// For connecting to a Cartridge application, use the value of cluster_cookie parameter in the init.lua file
				.withCredentials(username, password)
				// you may also specify more client settings, such as:
				// timeouts, number of connections, custom MessagePack entities to Java objects mapping, etc.
				.build();
	}

}
