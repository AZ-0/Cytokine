package fr.az.cytokine.app.resolve.conflict;

public enum ConflictHandlingStrategy
{
	RETAIN_MIN_DEPTH,
	RETAIN_MAX_DEPTH,
	RETAIN_FIRST_DECLARED,
	RETAIN_LAST_DECLARED,
	THROW_ERROR,
	;

	public static final ConflictHandlingStrategy DEFAULT = RETAIN_FIRST_DECLARED;
}