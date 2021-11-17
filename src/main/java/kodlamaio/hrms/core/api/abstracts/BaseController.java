package kodlamaio.hrms.core.api.abstracts;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import kodlamaio.hrms.core.business.abstracts.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public abstract class BaseController<TEntityService extends BaseService<TEntity, TEntityId>, TEntity, TEntityId> {
	private final TEntityService entityService;

	public BaseController(final TEntityService entityService) {
		this.entityService = entityService;
	}

	@PostMapping
	public ResponseEntity<Result> add(@RequestBody @Valid final TEntity entity) {
		final Result result = entityService.add(entity);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping
	public ResponseEntity<Result> delete(@RequestParam final TEntityId id) {
		final Result result = entityService.delete(id);

		return ResponseEntity.ok(result);
	}

	@GetMapping
	public ResponseEntity<DataResult<List<TEntity>>> getAll() {
		final DataResult<List<TEntity>> result = entityService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/byid")
	public ResponseEntity<DataResult<TEntity>> getById(final TEntityId id) {
		final DataResult<TEntity> result = entityService.getById(id);

		return ResponseEntity.ok(result);
	}

	@PutMapping
	public ResponseEntity<Result> update(@RequestBody @Valid final TEntity entity) {
		final Result result = entityService.update(entity);

		return ResponseEntity.ok(result);
	}
}
