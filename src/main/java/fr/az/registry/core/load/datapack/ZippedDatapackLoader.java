package fr.az.registry.core.load.datapack;

import java.nio.file.Path;
import java.util.Optional;
import java.util.zip.ZipFile;

import fr.az.registry.core.pack.DataPack;
import fr.az.registry.utils.Utils;

public class ZippedDatapackLoader implements DatapackLoader
{
	private final ZipFile zip;

	public ZippedDatapackLoader(Path path)
	{
		this.zip = Utils.safeOp(path.toFile(), ZipFile::new);
	}

	@Override
	public Optional<DataPack> loadDataPackUnhandled(String save)
	{
		if (this.zip == null)
			return Optional.empty();

		//TODO Load zipped datapack
		return Optional.empty();
	}
}
