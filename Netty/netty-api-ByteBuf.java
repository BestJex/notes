-----------------------------
ByteBuf						 |
-----------------------------
	#  abstract class ByteBuf implements ReferenceCounted, Comparable<ByteBuf>

-----------------------------
����						 |
-----------------------------
	long  readUnsignedInt()
	ByteBuf retainedDuplicate()

	short readUnsignedByte()

	ByteBuf markReaderIndex()
	ByteBuf resetReaderIndex()