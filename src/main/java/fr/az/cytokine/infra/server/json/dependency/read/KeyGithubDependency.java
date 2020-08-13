package fr.az.cytokine.infra.server.json.dependency.read;

import java.util.List;

import org.json.JSONObject;

import fr.az.cytokine.app.dependency.Dependency;
import fr.az.cytokine.app.dependency.GithubDependency;
import fr.az.cytokine.app.pack.PackType;
import fr.az.cytokine.app.version.Version;
import fr.az.cytokine.infra.server.github.GithubDependencyImpl;
import fr.az.cytokine.infra.server.json.Keys;
import fr.az.util.parsing.json.JSONParsingException;
import fr.az.util.parsing.json.keys.structure.Mandatory;
import fr.az.util.parsing.json.keys.structure.Structure;
import fr.az.util.parsing.json.keys.types.ObjectArrayKey;

public class KeyGithubDependency extends ObjectArrayKey<Dependency> implements DependencyKey<JSONObject>
{
	private static final long serialVersionUID = -8348951049194968239L;

	private static final Mandatory MANDATORY = new Mandatory(Keys.AUTHOR, Keys.NAME, Keys.VERSION, Keys.TYPE);

	@Override
	public GithubDependency build(List<Structure> structures) throws JSONParsingException
	{
		String author	= Keys.AUTHOR	.get(MANDATORY);
		String name		= Keys.NAME		.get(MANDATORY);
		Version version	= Keys.VERSION	.get(MANDATORY);
		PackType type	= Keys.TYPE		.get(MANDATORY);

		return new GithubDependencyImpl(author, name, type, version);
	}

	@Override public List<Structure> getStructures() { return List.of(MANDATORY); }
	@Override public String getKey() { return "github"; }
}
