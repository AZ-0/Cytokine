package fr.cytokine.server.json.dependency;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.az.cytokine.domain.dependency.Dependency;
import fr.cytokine.server.json.dependency.read.DependencyKey;
import fr.az.util.parsing.json.keys.structure.Optional;
import fr.az.util.parsing.json.keys.structure.Structure;
import fr.az.util.parsing.json.keys.types.ObjectKey;

public class KeyDependencies implements ObjectKey<List<Dependency>>
{
	private static final long serialVersionUID = -2336548736044746059L;

	private final Optional optional;

	public KeyDependencies()
	{
		this.optional = new Optional(DependencyKey.getKeys());
	}

	@Override
	public List<Dependency> build(List<Structure> structures)
	{
		Map<?, List<Dependency>> collected = this.optional.cast();

		List<Dependency> accumulated = new ArrayList<>();
		collected.values().forEach(accumulated::addAll);
		return accumulated;
	}

	@Override public List<Structure> getStructures() { return List.of(this.optional); }

	@Override public String getKey() { return "dependencies"; }
}
