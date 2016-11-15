package fr.insee.bar.service;

import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

@Service
public class NotificationService {

	@Autowired
	private CocktailService cocktailService;

	public void start(DeferredResult<String> result) {
		Executors
			.newSingleThreadExecutor()
			.execute(new NotificationRunnable(result));
	}

	public class NotificationRunnable implements Runnable {

		private DeferredResult<String> result;

		public NotificationRunnable(DeferredResult<String> result) {
			this.result = result;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1_000);
				cocktailService.hasard().ifPresent(c -> result.setResult(c.getNom()));
			}
			catch (InterruptedException e) {
				result.setErrorResult(e);
			}

		}

	}
}
