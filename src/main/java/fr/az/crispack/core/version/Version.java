package fr.az.crispack.core.version;

import fr.az.crispack.core.pack.PackIdentity;
import fr.az.crispack.core.pack.resolver.PackResolver;
import fr.az.crispack.core.version.table.VersionTable;

public interface Version extends Comparable<Version>
{
	String name();
	VersionTable table();
	int index();

	PackResolver produceResolver(PackIdentity identity);

	@Override
	default int compareTo(Version version)
	{
		if (version.table().equals(this.table()))
			throw new InvalidVersionException(version.toString(), "Compared versions should hold the same table");

		return Integer.compare(this.index(), version.index());
	}
}